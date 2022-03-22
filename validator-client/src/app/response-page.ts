import { CustomerResponse } from "./customer-response"

export class ResponsePage {

    totalPages:number;
    totalItems: number;
    currentPage: number;
    customerResponseList:CustomerResponse[];

    constructor(totalPages:number,totalItems:number,currentPage:number,customers:CustomerResponse[]){
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.currentPage = currentPage;
        this.customerResponseList = customers;
    }

}
