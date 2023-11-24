import {PageView} from '../../shared/data/shared.enum';
import {IPageButton, IPageTableCols, IPageTableHeader, IPageViewButton} from '../../shared/data/shared.interface';

export const pipelinePageButtons: IPageButton[] = [
    {
        text: 'Search',
        icon: 'search',
        size: 'medium',
        status: 'basic',
        shape: 'rectangle',
        action: () => {
        },
    },
    {
        text: 'Add',
        icon: 'plus',
        size: 'medium',
        status: 'primary',
        shape: 'rectangle',
        action: () => {
        },
    },
];

export const pipelinePageViewButtons: IPageViewButton[] = [
    {
        type: PageView.TABLE, action: () => {
        },
    },
    {
        type: PageView.GRID, action: () => {
        },
    },
    {
        type: PageView.LIST, action: () => {
        },
    },
];

export const pipelineTableHeader: IPageTableHeader = {
    title: 'pipeline',
    buttons: [
        {
            icon: 'cloud-download-outline', tooltip: 'Download Records', action: () => {
                console.info('some action');
            },
        },
        {
            icon: 'cloud-upload-outline', tooltip: 'Upload Records', action: () => {
            },
        },
        {
            icon: 'more-vertical-outline', tooltip: 'More Actions', action: () => {
            },
        },
    ],
};

export const pipelineTableColumns: IPageTableCols[] = [
    {title: 'First', type: 'string'},
    {title: 'Last', type: 'string'},
    {title: 'Handle of the pipeline', type: 'string'},
    {title: 'Date of Creation', type: 'string'},
    {title: 'State of the Pipeline', type: 'string'},
    {title: 'Status', type: 'string'},
    {title: 'Handle of the pipeline', type: 'string'},
    {title: 'Date of Creation', type: 'string'},
    {title: 'State of the Pipeline', type: 'string'},
    {title: 'Status', type: 'string'},
];
