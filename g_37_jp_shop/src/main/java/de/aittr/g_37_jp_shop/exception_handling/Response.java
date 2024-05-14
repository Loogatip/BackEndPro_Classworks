package de.aittr.g_37_jp_shop.exception_handling;

import java.util.Objects;

public class Response {

    private String massage;
    private String additionalMessage;

    public Response(String massage) {
        this.massage = massage;
    }
    public Response(String massage, String additionalMessage) {
        this.massage = massage;
        this.additionalMessage = additionalMessage;
    }

    public String getMassage() {
        return massage;
    }
    public String getAdditionalMessage() {
        return additionalMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (!Objects.equals(massage, response.massage)) return false;
        return Objects.equals(additionalMessage, response.additionalMessage);
    }
    @Override
    public int hashCode() {
        int result = massage != null ? massage.hashCode() : 0;
        result = 31 * result + (additionalMessage != null ? additionalMessage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "massage='" + massage + '\'' +
                ", additionalMessage='" + additionalMessage + '\'' +
                '}';
    }
}
