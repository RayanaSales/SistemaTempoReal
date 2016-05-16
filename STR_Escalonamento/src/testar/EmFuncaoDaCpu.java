package testar;

import configuracao.Escalonador;
import configuracao.Escalonavel;

public class EmFuncaoDaCpu implements Teste
{
    @Override
    public void calcular()
    {        
        for(int i=0 ; i<Escalonador.tarefas.size() ; i++)        
            Escalonador.somatorioUsoCpu += Escalonador.tarefas.get(i).getUtilizacaoCpu();
        
        if(Escalonador.somatorioUsoCpu < Escalonador.capacidadeProcessamentoTotal)
            Escalonador.escalonavel = Escalonavel.talvez;
        else if (Escalonador.somatorioUsoCpu > Escalonador.capacidadeProcessamentoTotal)
            Escalonador.escalonavel = Escalonavel.nao;        
    }    

    @Override
    public void mostrarResultado()
    {
        System.out.println("TESTE 1 - ESCALONABILIDADE, EM FUNÇÃO DA CPU.");        
        System.out.println("Capacidade de processamento total, do escalonador: " + Escalonador.capacidadeProcessamentoTotal);
        
        for(int i=0 ; i<Escalonador.tarefas.size(); i++)        
            System.out.println("Ultilização da cpu, para a tarefa " + i + ": " + Escalonador.tarefas.get(i).getUtilizacaoCpu());
                
        System.out.println("ESCALONAMENTO POSSIVEL? " + Escalonador.escalonavel);
    }
}
