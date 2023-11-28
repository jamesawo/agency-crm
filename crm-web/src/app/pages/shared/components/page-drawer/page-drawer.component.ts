import {Component, Input, OnInit} from '@angular/core';
import {DrawerService} from '../../service/drawer.service';

@Component({
    selector: 'ngx-page-drawer',
    templateUrl: './page-drawer.component.html',
    styleUrls: ['./page-drawer.component.scss']
})
export class PageDrawerComponent implements OnInit {
    @Input()
    title = '';

    constructor(private drawer: DrawerService) {
    }

    ngOnInit(): void {
    }

    onClose(value: boolean) {
        this.drawer.close();
    }

}
