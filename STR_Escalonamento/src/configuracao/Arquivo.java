package configuracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arquivo
{
	Scanner input = null;

	public Arquivo()
	{
		if (input == null)
		{
			input = new Scanner(System.in);
		}
	}

	public static String lerTxt()
	{
		String nome = "/home/rayana/NetBeansProjects/TempoReal_TestesEscalonabilidade/Entrada.txt";
		String linha = null;
		try
		{
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			linha = lerArq.readLine();

			while (linha != null)
			{
				System.out.printf("%s\n", linha);
				linha = lerArq.readLine();
			}

			arq.close();
		}
		catch (IOException e)
		{
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		return linha;
	}

	public void lerConsole_tarefas(String invocador) throws InputMismatchException	
	{
		System.out.println("Quem me chama: " + invocador);
				
		System.out.println("Digite a capacidade total do escalonador (double - virgula):");
		Escalonador.capacidadeProcessamentoTotal = input.nextDouble();
		String cont = "s";
		while (cont.equals("s"))
		{
			System.out.println("Digite os dados da nova tarefa:");
			Tarefa t = new Tarefa();

			System.out.println("carga de trabalho: (double - virgula)");
			t.carga = input.nextDouble();
			System.out.println("periodo: (double - virgula)");
			t.periodo = input.nextDouble();
			System.out.println("deadline: (double - virgula)");
			t.deadline = input.nextDouble();
			System.out.println("prioridade: (int)");
			t.prioridade = Integer.parseInt(input.next());
			
			Escalonador.tarefas.add(t);

			System.out.println("Continuar cadastrando tarefas? (s/n)");
			cont = input.next();
		}
	}

	public String lerConsole_tipoTeste()
	{
		System.out.println("Qual teste sera efetuado? 1, 2, ou 3 (Combine entradas, ex: 123, 321, 213, 1, 2, 3)");
		String tipoTeste = input.next();
		return tipoTeste;
	}
}
