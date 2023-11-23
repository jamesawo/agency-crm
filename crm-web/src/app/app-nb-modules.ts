import {NbEvaIconsModule} from '@nebular/eva-icons';
import {
    NbChatModule,
    NbDatepickerModule,
    NbDialogModule,
    NbMenuModule,
    NbSidebarModule,
    NbToastrModule,
    NbWindowModule,
} from '@nebular/theme';

export const NB_ROOT_MODULES: any = [
    NbSidebarModule.forRoot(),
    NbMenuModule.forRoot(),
    NbDatepickerModule.forRoot(),
    NbDialogModule.forRoot(),
    NbWindowModule.forRoot(),
    NbToastrModule.forRoot(),
    NbChatModule.forRoot({messageGoogleMapKey: ''}),
    NbEvaIconsModule,
];
