package br.com.danielsantdev.calculadorajuroscompostos;

public class Utils {

    public static double calcularJurosCompostos(double valorPrincipal, double taxaJuros, int anos, int periodoComposto) {
        return valorPrincipal * Math.pow(1 + taxaJuros / periodoComposto, periodoComposto * anos);

    }
}