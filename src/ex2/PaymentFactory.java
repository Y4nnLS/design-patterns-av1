package src.ex2;

class PaymentFactory {
    public static PaymentProcessor create(PaymentType type) {
        return switch (type) {
            case CREDIT_CARD -> new CreditCardProcessor();
            case BOLETO      -> new BoletoProcessor();
            case PIX         -> new PixProcessor();
            default          -> throw new IllegalArgumentException("Tipo de pagamento inválido");
        };
    }
}