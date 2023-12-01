import {HttpResponse} from '@angular/common/http';
import {IPaginate} from './shared.interface';

interface IResponse<T> {
    message?: string,
    status: number,
    data: T
}

export type ActionFn = (args?: any) => void;

export type PageResponse<T> = HttpResponse<IResponse<IPaginate<T>>>;

export type UnPageResponse<T> = HttpResponse<IResponse<T>>;
