public class Reporte {
    private String mes;     
    private String año;      

    public void generarReporteMensual(String mes) {
        this.mes = mes;
        System.out.println("Generando reporte del mes: " + this.mes);
    }

    public void generarReporteAnual(String año) {
        this.año = año;
        System.out.println("Generando reporte del año: " + this.año);
    }
}