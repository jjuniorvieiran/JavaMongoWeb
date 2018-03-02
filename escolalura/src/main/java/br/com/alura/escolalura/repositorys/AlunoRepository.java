package br.com.alura.escolalura.repositorys;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.Code;
import org.springframework.stereotype.Repository;

import br.com.alura.escolalura.codecs.AlunoCodec;
import br.com.alura.escolalura.models.Aluno;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class AlunoRepository {

	public void salvar(Aluno aluno) {
		
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		AlunoCodec alunoCodec = new AlunoCodec(codec);
		CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),	CodecRegistries.fromCodecs(alunoCodec));
		MongoClientOptions options = MongoClientOptions.builder().codecRegistry(registro).build();

		MongoClient cliente = new MongoClient("localhost:27017", options);
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		MongoCollection<Aluno> alunos = bancoDeDados.getCollection("alunos",
				Aluno.class);
		alunos.insertOne(aluno);

	}

}
