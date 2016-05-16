package configuracao;

import java.util.Comparator;

public class ComparadorTarefas implements Comparator<Tarefa>
{
	@Override
	public int compare(Tarefa o1, Tarefa o2)
	{
		if (o1.prioridade < o2.prioridade) return -1;
        else if (o1.prioridade > o2.prioridade) return +1;
        else return 0;		
	}
}
