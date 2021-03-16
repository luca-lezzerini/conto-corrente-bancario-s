import { ContoDeposito } from "../conto-deposito";
import { MovimentiContoDeposito } from "../movimenti-cd";

export class RitMovimentiCdDto {
    contoDeposito = new ContoDeposito();
    movimentiContoDeposito: MovimentiContoDeposito[] = [];
}