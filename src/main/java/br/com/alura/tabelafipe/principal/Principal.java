package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.service.ConsumoApi;
import br.com.alura.tabelafipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        String tipoVeiculo = null;
        while (true){
            System.out.println("**** OPÇÕES ****\nCarro\nMoto\nCaminhão");
            System.out.println("Digite uma das opções para consultar valores:");
            tipoVeiculo = leitura.nextLine();
            if (tipoVeiculo.equalsIgnoreCase("carro")) {
                tipoVeiculo = "carros";
                break;
            } else if (tipoVeiculo.equalsIgnoreCase("moto")) {
                tipoVeiculo = "motos";
                break;
            } else if (tipoVeiculo.equalsIgnoreCase("caminhão") || tipoVeiculo.equalsIgnoreCase("caminhao") ) {
                tipoVeiculo = "caminhoes";
                break;
            } else {
                System.out.println("Tipo de veículo inválido\nInforme um veículo válido!");
            }
        }



        var json = consumoApi.obterDados(ENDERECO + tipoVeiculo + "/marcas");
        System.out.println(json);

    }
}
