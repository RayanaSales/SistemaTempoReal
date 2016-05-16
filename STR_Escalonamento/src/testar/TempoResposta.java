package testar;

import java.util.Collections;

import configuracao.ComparadorTarefas;
import configuracao.Escalonador;
import configuracao.Escalonavel;
import configuracao.Tarefa;

public class TempoResposta implements Teste
{
	/* Para todas as tarefas:
	 * 	1- Pega a tarefa mais prejudicada (maior prioridade), e encontra os atrapalhadores dela (quem tem prioridade menor que ela), e coloca em uma lista (obj em tarefa)
	 * 	2- Ordena, lista de atrapalhadores, por prioridade (pq se estamos na tarefa 3, os atrapalhadores, são 2, 1 e 0)
	 * 	3- Declara duas variaveis: tempoRespAnt, tempoRespAtual
	 *  	3.1- Para o primeiro atrapalhador da lista: tempoRespAtual = minha carga
	 * 		-LOOP-
	 * 		3.2- tempoRespAnt = tempoRespAtual
	 * 			3.2.1- Estorou o deadline, ou o tempoRespAnt = tempoRespAtual? Se não, continue, se sim, encontramos, o tempoRespAtual.
	 * 		3.3- calcula somatorio: 
	 * 			3.3.1- for each para percorrer atrapalhadores (a cada loop, soma): Math.ceil(tempoRespAnt/atrapalhadoAtual.periodo) * atrapalhadoAtual.carga
	 * 		3.4- tempoRespAtual = minha carga + somatorio	 * 
	 * */
		
	private double tempoRespAnt, tempoRespAtual;
	private Tarefa maisPrejudicada;
	@Override
	public void calcular()
	{
		maisPrejudicada = Escalonador.buscaMaisPrejudicada();		
		Escalonador.setarAtrapalhadores();		
		Collections.sort(maisPrejudicada.atrapalhadores, new ComparadorTarefas()); //ordena atrapalhadores, de acordo com a prioridade.
		maisPrejudicada.mostrarAtrapalhadores();
		
		//primeiro valor
		tempoRespAtual = maisPrejudicada.carga;
		
		while(true)
		{
			tempoRespAnt = tempoRespAtual;// LIBERA VARIAVEL "ATUAL", NA FORMULA USAMOS A VARIAVEL "ANTES" (que eh o antigo atual)
			
			double somatorio = 0.0; //novo somatorio
			for(Tarefa atrapalhador : maisPrejudicada.atrapalhadores)		
				somatorio += Math.ceil(tempoRespAnt / atrapalhador.periodo) * atrapalhador.carga;
			
			tempoRespAtual = maisPrejudicada.carga + somatorio;	//NOVO ATUAL	
			
			System.out.println("tempoRespAnt: " + tempoRespAnt + " tempoRespAtual: " + tempoRespAtual);
			if(tempoRespAtual > maisPrejudicada.deadline)
			{
				Escalonador.escalonavel = Escalonavel.nao;
				break;
			}
			if(tempoRespAnt == tempoRespAtual)
			{
				Escalonador.escalonavel = Escalonavel.sim;
				break;
			}
		}
	}	
	
	@Override
	public void mostrarResultado()
	{		
		System.out.println("Deadline da mais prejudicada: " + maisPrejudicada.deadline);
		System.out.println("Tempo de resposta: " + tempoRespAtual);
		
		if(Escalonador.escalonavel == Escalonavel.nao)
			System.out.println("Não deu para escalonar. Estorou o deadline");
		else if (Escalonador.escalonavel == Escalonavel.sim)
			System.out.println("Deu para escalonar");
	}
}
