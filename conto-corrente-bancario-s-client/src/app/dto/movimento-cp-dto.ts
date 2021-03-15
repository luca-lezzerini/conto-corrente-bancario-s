import { ContoPrestito } from "../conto-prestito";
import { MovimentiContoPrestito } from "../movimenti-cp";

export class MovimentoCpDto{
    movimentoCp = new MovimentiContoPrestito();
    contoPrestito = new ContoPrestito();
}