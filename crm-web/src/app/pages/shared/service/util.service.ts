import {Injectable} from '@angular/core';
import {NbToastrService} from '@nebular/theme';
import {NbComponentOrCustomStatus} from '@nebular/theme/components/component-status';
import {firstValueFrom, Observable} from 'rxjs';
import {IOption} from '../data/shared.interface';

@Injectable({
    providedIn: 'root'
})
export class UtilService {

    constructor(private toast: NbToastrService) {
    }

    mapToOptionList<T extends Record<string, string>>(input: T): IOption[] {
        return Object.keys(input)
            .filter(key => isNaN(Number(key)))
            .map(key => ({
                label: key.replace(/_/g, ' '),
                value: input[key]
            }));
    }

    public async handleRequest<T>(
        arg: Observable<T>,
        message?: { success?: string; error?: string, title?: string }
    ): Promise<T> {

        try {
            const value: any = await firstValueFrom(arg);

            if (value && value?.ok) {
                this.showToast({message: value.body.message, title: message?.title ?? 'Success!', status: 'success'});
            } else {
                this.showToast({message: value.body.message, title: message?.title ?? 'Failed!', status: 'danger'});
            }
            return value;
        } catch (err: any) {
            const error = err.error;

            if (err && error) {
                const errMessage = this.isNetworkError(err) ? 'Network failure' : error.message;
                this.showToast({message: error.errors, title: errMessage, status: 'danger'});
            }
            // send error to logger service
            return Promise.resolve(err);
        }
    }

    public showToast(args: { status: NbComponentOrCustomStatus, message?: string, title?: string, }): void {
        let {message, title} = args;

        if (args.status === 'danger') {
            message = message ?? 'Something has gone wrong';
            title = title ?? 'An error occurred!';
        }

        this.toast.show(message, title,
            {duration: 10000, preventDuplicates: true, status: args.status});
    }

    private isNetworkError(err: any) {
        const message: string = err.message ?? '';
        return message.indexOf('Http failure response') === 0;
    }
}
