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
            {title: 'Manage pipelines', link: '/pages/pipelines/pipelines'},
            {title: 'Manage steps', link: '/pages/pipelines/steps'},
        ],
    },
    {
        title: 'Task',
        icon: 'clipboard-outline',
        children: [
            {title: 'Manage tasks', link: '/pages/tasks'},
        ],
    },
    {
        title: 'Team',
        icon: 'umbrella-outline',
        children: [
            {title: 'Manage teams', link: '/pages/teams'},
        ],
    },
    {
        title: 'Supervisor',
        icon: 'monitor-outline',
        children: [
            // a supervisor is a manager in the backed
            {title: 'Manage supervisors', link: '/pages/supervisors'},
        ],
    },
    {
        title: 'Agent',
        icon: 'people-outline',
        children: [
            {title: 'Manage agents', link: '/pages/agents/agents'},
            {title: 'Manage agent\'s task', link: '/pages/agents/tasks'},
            {title: 'Manage agent\'s team', link: '/pages/agents/teams'},
            {title: 'Manage agent\'s clients', link: '/pages/agents/clients'},
            {title: 'View agent\'s performance', link: 'pages/agents/view-performances'},
        ],
    },
    {
        title: 'Client',
        icon: 'pantone-outline',
        children: [
            {title: 'Manage clients', link: '/pages/clients'},
        ],
    },
    {
        title: 'Authorization',
        icon: 'unlock-outline',
        children: [
            {title: 'Manage users', link: '/pages/auth/users'},
            {title: 'Manage roles ', link: '/pages/auth/roles'},
            {title: 'Manage permission ', link: '/pages/auth/permissions'},
        ],
    },
];
