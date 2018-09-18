import {Component, Input, OnInit, EventEmitter} from '@angular/core';
import {Login} from "../../shared/models/login";
import {ToasterService} from "angular5-toaster/dist";

import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UsersService} from "../../core/services/users.service";
import {Account} from "../../shared/models/account";

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css']
})
export class UserModalComponent implements OnInit {

  modalRef: BsModalRef;
  @Input() account: Account;
  @Input() change: boolean;

  save: EventEmitter<Account> = new EventEmitter();

  constructor(private modalService : BsModalService) {

    this.account = new Account('','','','');
    this.change = false;
  }

  ngOnInit() {
  }

  send(){
    this.save.emit(this.account);
    this.modalRef.hide();
  }
}
