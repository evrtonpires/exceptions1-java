package pacotePrincipal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.DominoExcecao;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
//------------------------------------------------------------------------------------------------------------
		try {
			System.out.print("Numero do Quarto : ");
			int numeroQuarto = sc.nextInt();
			
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			Date dataSaida = sdf.parse(sc.next());
//------------------------------------------------------------------------------------------------------------	
		
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println(reserva);
			
			System.out.println("----------------------------------------------------");
			
			System.out.println("\nEntre com a Data Atualizada : ");
			
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			dataSaida = sdf.parse(sc.next());
//------------------------------------------------------------------------------------------------------------		
			reserva.dataAtualizada(dataEntrada, dataSaida);
			
			System.out.println(reserva);
			}
			catch(ParseException e){
				System.out.println("\nData Invalida ! ");	
			}
		
			catch(DominoExcecao e){
				System.out.println("\nErro na reserva : "+e.getMessage());
			}
		catch(RuntimeException e) {
			System.out.println("Erro : Digite um Numero Inteiro");
		}
		
		sc.close();

	}

}

