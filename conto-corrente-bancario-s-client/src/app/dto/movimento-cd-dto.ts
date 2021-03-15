import { ContoDeposito } from "../conto-deposito";
import { MovimentiContoDeposito } from "../movimenti-cd";

export class MovimentoCdDto {
    movimentoCd = new MovimentiContoDeposito();
    contoDeposito = new ContoDeposito();
}