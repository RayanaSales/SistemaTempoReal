package configuracao;

import java.util.ArrayList;
import java.util.List;

public class Escalonador
{
    public static List<Tarefa> tarefas = new ArrayList<>(); 
    
    public static Escalonavel escalonavel;     
    public static double capacidadeProcessamentoTotal;
    public static double somatorioUsoCpu;
    
    public static Tarefa buscaMaisPrejudicada()
	{
		int maior = 0;		
		maior = tarefas.get(0).prioridade;
		Tarefa maisPrejudicada = tarefas.get(0);
		
		for(int i = 0 ; i< tarefas.size() ; i++)
		{
			if(tarefas.get(i).prioridade > maior)
			{
				maior = tarefas.get(i).prioridade;
				maisPrejudicada = tarefas.get(i);
			}
		}	
		System.out.println("Prioridade da mais prejudicada: " + maisPrejudicada.prioridade);
		return maisPrejudicada;	
	}

    public static void setarAtrapalhadores()
    {
    	for(int i = 0 ; i<tarefas.size() ; i++) //tarefa atual - buscar atrapalhadores
    	{  		
    		for(int j = 0 ; j<tarefas.size() ; j++) //vendo se na lista, tem alguem menor que eu
    		{
    			if(tarefas.get(j).prioridade < tarefas.get(i).prioridade)
    				tarefas.get(i).atrapalhadores.add(tarefas.get(j));    			
    		}
    	}
    }
}
