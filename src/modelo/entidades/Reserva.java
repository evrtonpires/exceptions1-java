package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}


	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao() {
		long diff = dataSaida.getTime() - dataEntrada.getTime(); // pegando a diferença em milisegundos de uma data para a outra
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// converte o valor da varial DIFF que está em milisegundos, para dias.
		
	}
	
	public void dataAtualizada(Date dataEntrada , Date dataSaida ) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	@Override
	public String toString() {
		System.out.println("----------------------------------------------------");
		return "\nQuarto "+numeroQuarto + "\nData de Entrada : "+ sdf.format(dataEntrada) + "\nData de Saida : "+sdf.format(dataSaida) + "\nTempo Hospedado : "+duracao() + " Dias";
	}

}
