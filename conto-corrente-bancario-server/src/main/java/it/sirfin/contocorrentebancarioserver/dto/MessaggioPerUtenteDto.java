package it.sirfin.contocorrentebancarioserver.dto;


public class MessaggioPerUtenteDto {
    private String messaggio;

    public MessaggioPerUtenteDto() {
    }

    public MessaggioPerUtenteDto(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
    
}
