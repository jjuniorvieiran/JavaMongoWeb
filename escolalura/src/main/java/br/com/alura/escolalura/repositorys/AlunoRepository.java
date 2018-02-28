package br.com.alura.escolalura.repositorys;

import org.springframework.stereotype.Repository;

import br.com.alura.escolalura.models.Aluno;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class AlunoRepository {
	
	public void salvar(Aluno aluno){
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		MongoCollection<Aluno> alunos = bancoDeDados.getCollection("alunos", Aluno.class);
		alunos.insertOne(aluno);
		cliente.close();
	}

}
