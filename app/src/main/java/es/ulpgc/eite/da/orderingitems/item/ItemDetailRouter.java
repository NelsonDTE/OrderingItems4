package es.ulpgc.eite.da.orderingitems.item;


import es.ulpgc.eite.da.orderingitems.app.AppMediator;
import es.ulpgc.eite.da.orderingitems.app.DetailToListState;
import es.ulpgc.eite.da.orderingitems.app.ListToDetailState;
import es.ulpgc.eite.da.orderingitems.data.ItemData;
import es.ulpgc.eite.da.orderingitems.items.ItemListState;

public class ItemDetailRouter implements ItemDetailContract.Router {

  public static String TAG = ItemDetailRouter.class.getSimpleName();

  private AppMediator mediator;
  private ListToDetailState listToDetailState;
  private DetailToListState detailToListState;

  public ItemDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void passStateToPreviousScreen(DetailToListState state) {
    //TODO: falta implementacion
    detailToListState = state ;
  }

  @Override
  public ListToDetailState getStateFromPreviousScreen() {
    //TODO: falta implementacion
      ListToDetailState state = listToDetailState;
      listToDetailState = null;
    return state;
  }

}
