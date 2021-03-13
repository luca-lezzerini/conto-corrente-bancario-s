import { Cliente } from "./cliente";
import { ContoDeposito } from "./conto-deposito";

export class AssociaCdDto {
    cliente: Cliente;
    contoDeposito: ContoDeposito;
}