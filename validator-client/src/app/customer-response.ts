export class CustomerResponse {

    name: string;
    phone: string;
    countryCode: string;
    country: string;
    valid:boolean;

    constructor(name :string,phone:string,countryCode:string,country:string,isValid:boolean){
        this.name = name;
        this.phone = phone;
        this.countryCode = countryCode;
        this.country = country;
        this.valid = isValid;
    }


    
}
