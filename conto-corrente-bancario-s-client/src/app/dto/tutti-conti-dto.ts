import { ContoCorrente } from "../conto-corrente";
import { ContoDeposito } from "../conto-deposito"
import { ContoPrestito } from "../conto-prestito";

export class TuttiContiDto {
    contiDeposito: ContoDeposito[] = [];
    contiCorrenti: ContoCorrente[] = [];
    contiPrestito: ContoPrestito[] = [];
} 