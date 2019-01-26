package pacotePrincipal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
//------------------------------------------------------------------------------------------------------------
		System.out.print("Numero do Quarto : ");
		int numeroQuarto = sc.nextInt();
		
		System.out.print("Data de Entrada (dd/MM/yyyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		
		System.out.print("Data de Saida (dd/MM/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());
//------------------------------------------------------------------------------------------------------------	
		if (!dataSaida.after(dataEntrada)) { //After serve para testar se a data eh depois da outra.
			System.out.println("\nErro na Reserva. A Data de Saida deve ser depois da Data de Entrada!");
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println(reserva);
			
			System.out.println("----------------------------------------------------");
			
			System.out.println("\nEntre com a Data Atualizada : ");
			
			System.out.print("Data de Entrada (dd/MM/yyyy): ");
			dataEntrada = sdf.parse(sc.next());
			
			System.out.print("Data de Saida (dd/MM/yyyy): ");
			dataSaida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (dataEntrada.before(agora)|| dataSaida.before(agora)){ //Esta informando que as datas de atualização nao podem ser anteriores a data atual
				System.out.println("\nErro na Reserva. Reserve datas Futuras !");
			}
			else if (!dataSaida.after(dataEntrada)) {
				System.out.println("\nErro na Reserva. A Data de Saida deve ser depois da Data de Entrada!");
			}
			else {
			reserva.dataAtualizada(dataEntrada, dataSaida);
			
			System.out.println(reserva);
			
		}
		
		sc.close();

	}

}
}
