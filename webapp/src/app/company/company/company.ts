import { BoardOfDirectors } from './boardOfDirectors';
import { Sector } from './Sector';
import { StockExchange } from './stockExchange';

export interface Company{
    id: number;
    companycode: number;
    name: string;
    turnover: number;
    ceo: string;
    boardOfDirectorsList: BoardOfDirectors[];
    listed: boolean;
    sector: Sector;
    auboutCompany: string;
    stockExchangeList: StockExchange[];
}