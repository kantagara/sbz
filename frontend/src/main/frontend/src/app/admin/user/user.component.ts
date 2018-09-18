import { Component, OnInit } from '@angular/core';
import {UsersService} from "../../core/services/users.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserModalComponent} from "../user-modal/user-modal.component";
import {Account} from "../../shared/models/account";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  admins: Array<Account>;
  doctors : Array<Account>;

  modalRef: BsModalRef;

  constructor(private userService: UsersService, private modalService : BsModalService) {

    this.userService.getAllByRole("ADMIN").subscribe(data =>{
      this.admins = data;
    });
    this.userService.getAllByRole("DOCTOR").subscribe(data =>{
      this.doctors = data;
    })

  }

  ngOnInit() {
  }

  change(acc : Account){
    this.modalRef = this.modalService.show(UserModalComponent);
    this.modalRef.content.change = true;
    this.modalRef.content.account = acc;
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.save.subscribe(data =>{
      this.userService.change(data).subscribe(data =>{
        console.log(data);
      });
    });
  }

  register(isAdmin:boolean){
    this.modalRef = this.modalService.show(UserModalComponent);
    this.modalRef.content.change = false;
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.save.subscribe(data =>{
      this.userService.register(data, isAdmin).subscribe(data =>{
      });
    });
  }

  delete(acc:Account, isAdmin: boolean){
    this.userService.delete(acc.username).subscribe(data =>{
        this.deleteFromArray(isAdmin? this.admins: this.doctors, acc);
    });
  }

   deleteFromArray(accounts: Array<Account>, account: Account) {
      let index = accounts.indexOf(account);
      accounts.splice(index, 1);
  }

}
