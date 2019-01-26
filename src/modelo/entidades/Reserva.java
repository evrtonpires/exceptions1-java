package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.DominoExcecao;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		
		if (!dataSaida.after(dataEntrada)) {
			throw new DominoExcecao("\nErro na Reserva. A Data de Saida deve ser depois da Data de Entrada!");
		}
		
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
		Date agora = new Date();
		if (dataEntrada.before(agora) || dataSaida.before(agora)){ //Esta informando que as datas de atualização nao podem ser anteriores a data atual
			throw new DominoExcecao("\nErro na Reserva. Reserve datas Futuras !");
		}
		if (!dataSaida.after(dataEntrada)) {
			throw new DominoExcecao("\nErro na Reserva. A Data de Saida deve ser depois da Data de Entrada!");
		}
		// se denhuma das situações acima acontecer, ai entao, ira atualizar as datas.
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		
	}
	
	@Override
	public String toString() {
		System.out.println("----------------------------------------------------");
		return "\nQuarto "+numeroQuarto + "\nData de Entrada : "+ sdf.format(dataEntrada) + "\nData de Saida : "+sdf.format(dataSaida) + "\nTempo Hospedado : "+duracao() + " Dias";
	}

}
