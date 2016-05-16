package configuracao;

import java.util.ArrayList;
import java.util.List;

public class Tarefa
{
	public double carga, periodo, deadline;
	public int prioridade;

	public List<Tarefa> atrapalhadores;

	public Tarefa()
	{
		atrapalhadores = new ArrayList<Tarefa>();
	}

	public double getUtilizacaoCpu()
	{
		return carga / periodo;
	}

	public void mostrarAtrapalhadores()
	{
		System.out.println("Me atrapalham: ");
		for (Tarefa atrapalhadora : atrapalhadores)	
			System.out.println("    tarefa: " + atrapalhadora.prioridade);

	}
}
