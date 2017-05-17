import { AngularVideoclubPage } from './app.po';

describe('angular-videoclub App', () => {
  let page: AngularVideoclubPage;

  beforeEach(() => {
    page = new AngularVideoclubPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
