package grafica.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import grafica.modelo.Pedido;

public class Grafica {
	
	private static Scanner entrada;
	
	public static void main(String[] args) {
	/*	
		Copia copia= new Copia(ModeloCopia.CORA4);
		Impressao impressao= new Impressao(ModeloImpressao.PBA3);
		CartaoVisita cartaoVisita= new CartaoVisita(ModeloCartaoVisita.FRENTE);
		Plastificacao plastificacao= new Plastificacao(ModeloPlastificacao.A4);
		Encadernacao encadernacao= new Encadernacao(ModeloEncadernacao.DURACOSTURA);
		
		ItemPedido itemPedido= new ItemPedido(copia, 3);
		ItemPedido itemPedido2= new ItemPedido(impressao, 2);
		ItemPedido itemPedido3= new ItemPedido(cartaoVisita, 2);
		ItemPedido itemPedido4= new ItemPedido(plastificacao, 1);
		ItemPedido itemPedido5= new ItemPedido(encadernacao, 1);
		
		Pedido pedido= new Pedido();
		pedido.insereItem(itemPedido);
		pedido.insereItem(itemPedido2);
		pedido.insereItem(itemPedido3);
		pedido.insereItem(itemPedido4);
		pedido.insereItem(itemPedido5);
		
		System.out.println(pedido);*/
		
		entrada= new Scanner(System.in);
		
		Pedido pedido= realizarAtendimento();
		//gerarRecibo(pedido);
		
		entrada.close();
	}	
	
	private static Pedido realizarAtendimento() {
						
		boolean atendimentoConcluido= false;
		Pedido pedido= new Pedido();
		
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------- GRÁFICA --------------------");
		System.out.println("-------------------------------------------------");
				
		while(!atendimentoConcluido) {
			prestarServico(pedido);	
			
			int escolha;
			System.out.println(".\n.\n.Há outro o serviço a ser registrado? ");
			System.out.println( ".1. Sim .......... 2. Não");
			escolha= lerInteiroTeclado(1, 2);
			
			if(escolha == 2)
				atendimentoConcluido= true;
		}		
		
		System.out.println("-------------------------------------------------");
		System.out.println("------------- Atendimento concluído -------------");
		
		return pedido;
	}
	
	private static void prestarServico(Pedido pedido) {
		
		
	}
	
	private static int lerInteiroTeclado(int opcaoInicial, int opcaoFinal) {

		int numero= 0;
		boolean leitura= true;

		while(leitura) {
			try {
				System.out.print(".> ");
				numero= entrada.nextInt(); 

				if(numero >= opcaoInicial && numero <= opcaoFinal)
					leitura= false;
				else
					System.err.print(".Informe um valor válido!\n");

			}catch (InputMismatchException e) {
				System.err.print(".Informe um valor válido!\n");

			}finally {
				if(entrada.hasNextLine())
					entrada.nextLine();	
			}
		}

		return numero;
	}
}