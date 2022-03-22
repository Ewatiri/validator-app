import { Component, OnInit } from '@angular/core';
import { CustomerResponse } from '../customer-response';
import { CustomerServiceService } from '../customer-service.service';
import { ResponsePage } from '../response-page';

@Component({
  selector: 'app-validator-filter',
  templateUrl: './validator-filter.component.html',
  styleUrls: ['./validator-filter.component.css']
})
export class ValidatorFilterComponent implements OnInit {

  customerList: CustomerResponse[];
  countries:any = ["Cameroon","Ethiopia","Morocco","Mozambique","Uganda"];
  valueData :any = {};

  constructor(private customerService: CustomerServiceService) { }

  ngOnInit(): void {
    this.valueData.state = "all";
    this.valueData.country = "all";
    this.filterData();
  }

  filterData():void{
    this.customerService.getAll(this.valueData.state, this.valueData.country).subscribe((data: any)=>{
      this.customerList = data;
      console.log(data);
    });
  }

}
