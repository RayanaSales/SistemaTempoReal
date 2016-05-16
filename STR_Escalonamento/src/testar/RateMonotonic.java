package testar;

import configuracao.Escalonador;
import configuracao.Escalonavel;

public class RateMonotonic implements Teste
{
	double resultadoRaiz, segundaParte;

	@Override
	public void calcular()
	{
//		if (Escalonador.somatorioUsoCpu == 0) //se não temos o somatorio ainda, precisamos dele, e das tarefas
//		{
//			Arquivo arquivo = new Arquivo();
//			arquivo.lerConsole_tarefas("rate");
//			Teste teste = new EmFuncaoDaCpu();
//			teste.calcular();
//		}		
		
		// Calculando raiz:
		int radical = 2;
		int n = Escalonador.tarefas.size();
		resultadoRaiz = Math.pow(radical, 1.0 / n);

		// Aplicando formula:
		segundaParte = n * (resultadoRaiz - 1);

		if (Escalonador.somatorioUsoCpu <= segundaParte)
			Escalonador.escalonavel = Escalonavel.talvez;
		else if (Escalonador.somatorioUsoCpu >= segundaParte)
			Escalonador.escalonavel = Escalonavel.nao;
	}

	@Override
	public void mostrarResultado()
	{
		System.out.println("TESTE 2 - RATE MONOTONIC");
		System.out.println("Somatorio da cpu: " + Escalonador.somatorioUsoCpu);
		System.out.println("Quantidade de tarefas: "+ Escalonador.tarefas.size());
		System.out.println("Resultado raiz: " + resultadoRaiz);
		System.out.println("Segunda parte da formula: " + segundaParte);
		System.out.println("ESCALONAMENTO POSSIVEL? " + Escalonador.escalonavel);
	}
}
