import { ContoCorrente } from "../conto-corrente";
import { MovimentiContoCorrente } from "../movimenti-conto-corrente";

export class MovimentoCcDto {
    movimentoCc = new MovimentiContoCorrente(); //movimento generico che compio
    contoCorrente = new ContoCorrente(); //metto la classe che contiene i parametri di contocorrente
}