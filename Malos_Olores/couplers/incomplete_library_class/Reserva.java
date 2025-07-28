import java.time.LocalDate;
import java.time.DayOfWeek;

public class Reserva {
    private LocalDate fecha;

    public Reserva(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean esFinDeSemana() {
        DayOfWeek dia = fecha.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
    }
}