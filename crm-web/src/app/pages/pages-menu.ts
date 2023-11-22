import {NbMenuItem} from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
    {
        title: 'Welcome',
        icon: 'home-outline',
        link: '/pages/welcome',
        home: true,
    },
    {
        title: 'MODULES',
        group: true,
    },
    {
        title: 'Dashboard',
        icon: 'activity-outline',
        link: '/pages/dashboard',
    },
    {
        title: 'PipeLine',
        icon: 'swap-outline',
        children: [
            // step represent a stage in the backend
            {title: 'manage pipelines', link: '/pages/pipelines/pipelines'},
            {title: 'manage steps', link: '/pages/pipelines/steps'},
        ],
    },
    {
        title: 'Task',
        icon: 'clipboard-outline',
        children: [
            {title: 'manage tasks', link: '/pages/tasks'},
        ],
    },
    {
        title: 'Team',
        icon: 'umbrella-outline',
        children: [
            {title: 'manage teams', link: '/pages/teams'},
        ],
    },
    {
        title: 'Supervisor',
        icon: 'monitor-outline',
        children: [
            // a supervisor is a manager in the backed
            {title: 'manage supervisors', link: '/pages/supervisors'},
        ],
    },
    {
        title: 'Agent',
        icon: 'people-outline',
        children: [
            {title: 'manage agents', link: '/pages/agents/agents'},
            {title: 'manage agent\'s task', link: '/pages/agents/tasks'},
            {title: 'manage agent\'s team', link: '/pages/agents/teams'},
            {title: 'manage agent\'s clients', link: '/pages/agents/clients'},
            {title: 'view agent\'s performance', link: 'pages/agents/view-performances'},
        ],
    },
    {
        title: 'Client',
        icon: 'pantone-outline',
        children: [
            {title: 'manage clients', link: '/pages/clients'},
        ],
    },
    {
        title: 'Authorization',
        icon: 'unlock-outline',
        children: [
            {title: 'manage users', link: '/pages/auth/users'},
            {title: 'manage roles ', link: '/pages/auth/roles'},
            {title: 'manage permission ', link: '/pages/auth/permissions'},
        ],
    },
];
