package src.ex4;

abstract class ReportDecorator implements Report {

    protected final Report wrappee;

    protected ReportDecorator(Report wrappee) {
        this.wrappee = wrappee;
    }
}
