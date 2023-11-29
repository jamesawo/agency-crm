import {Injectable, Type} from '@angular/core';
import {NbDialogRef, NbDialogService} from '@nebular/theme';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DrawerService {
    private currentDrawer: BehaviorSubject<NbDialogRef<any>>;
    private currentDrawer$: Observable<NbDialogRef<any>>;

    constructor(private dialog: NbDialogService) {
        this.currentDrawer = new BehaviorSubject(null);
        this.currentDrawer$ = this.currentDrawer.asObservable();
    }

    public open(component: Type<any>): NbDialogRef<any> {
        const ref = this.dialog.open(component);
        this.currentDrawer.next(ref);
        return ref;
    }

    public close(): void {
        if (this.currentDrawer.value !== null) {
            this.currentDrawer.value.close();
            this.currentDrawer.next(null);
        }
    }
}
