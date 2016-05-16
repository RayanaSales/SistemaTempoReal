package configuracao;

import testar.EmFuncaoDaCpu;
import testar.RateMonotonic;
import testar.TempoResposta;
import testar.Teste;

public class Main
{
    public static void main(String[] args)
    {
        Arquivo arquivo = new Arquivo();        
        String testeTipo = arquivo.lerConsole_tipoTeste();
        arquivo.lerConsole_tarefas("main");
        
        Teste teste =  null;        
        if(testeTipo.contains("1"))
        {
            teste = new EmFuncaoDaCpu();            
            executa(teste);         
        }  
        if(testeTipo.contains("2"))
        {
        	teste = new RateMonotonic();
        	executa(teste);
        }
        if(testeTipo.contains("3"))
        {
        	teste = new TempoResposta();
        	executa(teste);
        }
    }
    
    public static void executa(Teste teste)
    {
    	teste.calcular();
        teste.mostrarResultado(); 
    }
}
