package es.ulpgc.eite.da.orderingitems.item;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.orderingitems.app.DetailToListState;
import es.ulpgc.eite.da.orderingitems.app.ListToDetailState;

public class ItemDetailPresenter implements ItemDetailContract.Presenter {

  public static String TAG = ItemDetailPresenter.class.getSimpleName();

  private WeakReference<ItemDetailContract.View> view;
  private ItemDetailState state;
  private ItemDetailContract.Model model;
  private ItemDetailContract.Router router;

  public ItemDetailPresenter(ItemDetailState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new ItemDetailState();
    }

    state.numOfClicks=0;

    //TODO: falta implementacion
    ListToDetailState savedState= router.getStateFromPreviousScreen();
    if(savedState != null){
    model.onDataFromPreviousScreen(savedState.data, state.listSize);
    }
  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    //TODO: falta implementacion
    model.onRestartScreen(state.data, state.listSize);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    //TODO: falta implementacion
    state.data = model.getStoredData();


    view.get().onDataUpdated(state);
  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");

    //TODO: falta implementacion
    router.passStateToPreviousScreen(new DetailToListState(state.data));
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onButtonTapped() {
    // Log.e(TAG, "onButtonTapped()");

    //TODO: falta implementacion
    model.onIncrPosition();
    onResume();

  }

  @Override
  public void injectView(WeakReference<ItemDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ItemDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ItemDetailContract.Router router) {
    this.router = router;
  }
}
