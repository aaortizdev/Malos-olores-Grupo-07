public class TransferenciaService {

    // Este método realiza una transferencia de dinero entre cuentas
    public void procesarTransferencia(Cuenta origen, Cuenta destino, double monto) {
        // Verifica si el saldo es suficiente
        if (origen.getSaldo() >= monto) {
            // Resta el monto de la cuenta origen
            origen.debitar(monto);
            // Suma el monto a la cuenta destino
            destino.acreditar(monto);
            // Registra la transferencia
            registrarEnHistorial(origen, destino, monto);
        } else {
            // Lanza excepción si no hay saldo
            throw new SaldoInsuficienteException("Fondos insuficientes");
        }
    }
}
