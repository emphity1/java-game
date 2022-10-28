package game.states;

import java.awt.Graphics;

import game.Assets;
import game.UI.ClickListener;
import game.UI.UIImageButton;
import game.UI.UIManager;
import game.handler.Handler;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(512-96, 360-32, 192, 64 ,Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		handler.getMouseManager().setUIManager(null);
		State.setState(handler.getGame().gameState);
		//uiManager.render(g);
	}

}