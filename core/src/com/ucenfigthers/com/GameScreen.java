package com.ucenfigthers.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.utils.TimeUtils.millis;

public class GameScreen extends ApplicationAdapter {
	SpriteBatch batch;

	//hoshiChie
	private TextureAtlas hoshiIdleAtlas;
	private Animation hoshiIdle;
	private TextureAtlas hoshiWalkFAtlas;
	private Animation hoshiWalkF;
	private TextureAtlas hoshiWalkBAtlas;
	private Animation hoshiWalkB;
	private float hoshiX;
	private float hoshiY;
    private float hoshiAttackX;
    private float hoshiAttackY;
	private float hoshiSpeed = 250.0f;
	private float jordanX;
	private float jordanY;
	private float jordanSpeed = 300.0f;
	private Music reachOut;
	private Music gods;
	private Music chie;
	private Music last;

    private long time;
    private long ttime;

	private boolean hoshiAction = false;
    private boolean hoshiMovement = false;
    private boolean hoshiKnock = false;
	private boolean jordanAction = false;
    private boolean hoshiBack = false;
    private boolean jordanBack = false;
    boolean jordan1 = false;
    boolean jordan2 = false;
    boolean jordan3 = false;
    boolean jordan4 = false;
    boolean jordan5 = false;
    boolean jordan6 = false;
    boolean jordanMovement = false;
    boolean start = true;

    boolean hoshi1 = false;
    boolean hoshi2 = false;
    boolean hoshi3 = false;
    boolean hoshi4 = false;
    boolean hoshi5 = false;
    boolean hoshi6 = false;

    private Texture healthBackground;
	private Texture healthHoshi;
	private Texture healthJordan;

    private Texture round1;

	private Texture ko;

	private Texture hoshiFace;

	private boolean fighto = true;

	TextureAtlas hoshilowPunchAtlas;
	Animation hoshilowPunch;
	TextureAtlas hoshimediumPunchAtlas;
	Animation hoshimediumPunch;
	TextureAtlas hoshihighPunchAtlas;
	Animation hoshihighPunch;
	TextureAtlas hoshilowKickAtlas;
	Animation hoshilowKick;
	TextureAtlas hoshimediumKickAtlas;
	Animation hoshimediumKick;
    TextureAtlas hoshispecialAtlas;
	Animation hoshispecial;
    TextureAtlas hoshiKnockbackAtlas;
    Animation hoshiKnocback;

	//JORDAN
	TextureAtlas jordanIdleAtlas;
	Animation jordanIdle;
	TextureAtlas jordanLowPunchAtlas;
	Animation jordanLowPunch;
	TextureAtlas jordanCrouchStartAtlas;
	Animation jordanCrouchStart;
	TextureAtlas jordanCrouchAtlas;
	Animation jordanCrouch;
	TextureAtlas jordanJumpAtlas;
	Animation jordanJump;
	TextureAtlas jordanCrouchLowPunchAtlas;
	Animation jordanCrouchLowPunch;
	TextureAtlas jordanKnockbackAtlas;
	Animation jordanKnockback;
	TextureAtlas jordanKnockbackStrongAtlas;
	Animation jordanKnockbackStrong;
	TextureAtlas jordanJumpStartAtlas;
	Animation jordanJumpStart;
	TextureAtlas jordanJumpEndAtlas;
	Animation jordanJumpEnd;
	TextureAtlas jordanWalkForwardAtlas;
	Animation jordanWalkForward;
	TextureAtlas jordanWalkBackwardsAtlas;
	Animation jordanWalkBackwards;

	Texture jordanFace;

	float jordanHealth;
	float hoshiHealth;

	Sound effect;
	Sound jordanLowPunchSound;
	Sound punch;
	Sound swing;
	Sound FIGHT;

	Rectangle jordanBounds;
	Rectangle hoshiBounds;
    Rectangle hoshiAttackBounds;


	public void show() {
	}

	private float hoshiTime = 0f;
    private float hoshiAttackTime = 0f;
	private float jordanTime = 0f;
	private float elapsedTime = 0f;
	private Texture texture;
	private boolean music1 = true;
	private boolean music2 = false;
	private boolean music3 = false;
	private boolean music4 = false;

	public void create() {
		reachOut = Gdx.audio.newMusic(Gdx.files.internal("music/hoshi/reach.mp3"));
		gods = Gdx.audio.newMusic(Gdx.files.internal("music/hoshi/gods.mp3"));
		chie = Gdx.audio.newMusic(Gdx.files.internal("music/hoshi/chie.mp3"));
		last = Gdx.audio.newMusic(Gdx.files.internal("music/hoshi/last.mp3"));


        time = millis();
        ttime = time + 5000;

        round1 = new Texture("round1.png");
		ko = new Texture("ko.png");

		hoshiFace = new Texture(Gdx.files.internal("sprites/hoshi/hoshiFace.png"));

		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("stage_1.JPG"));
		jordanFace = new Texture(Gdx.files.internal("sprites/jordan/jordanFace.png"));

		hoshiX = Gdx.graphics.getWidth() - 200;
		hoshiY = 50;

		jordanX = 50;
		jordanY = 50;

		jordanHealth = 1.0f;
		hoshiHealth = 1.0f;

		jordanBounds = new Rectangle(jordanX, jordanY, 300, 400);
		hoshiBounds = new Rectangle(hoshiX, hoshiY, 400, 400);
        hoshiAttackBounds = new Rectangle(hoshiAttackX, hoshiAttackY, 470, 473);

		healthJordan = new Texture(Gdx.files.internal("health.png"));
		healthHoshi = new Texture(Gdx.files.internal("health.png"));
		healthBackground = new Texture(Gdx.files.internal("healthBack.png"));

		//JORDAN SPRITES
		jordanCrouchStartAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/crouch/start/sprites.atlas"));
		jordanCrouchStart = new Animation(1f / 10f, jordanCrouchStartAtlas.getRegions());
		jordanCrouchAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/crouch/idle/sprites.atlas"));
		jordanCrouch = new Animation(1f / 10f, jordanCrouchAtlas.getRegions());
		jordanCrouchLowPunchAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/crouchLowPunch/sprites.atlas"));
		jordanCrouchLowPunch = new Animation(1f / 10f, jordanCrouchLowPunchAtlas.getRegions());
		jordanIdleAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/idle/sprites.atlas"));
		jordanIdle = new Animation(1f / 10f, jordanIdleAtlas.getRegions());
		jordanJumpAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/jump/sprites.atlas"));
		jordanJump = new Animation(1f / 10f, jordanJumpAtlas.getRegions());
		jordanKnockbackStrongAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/knockbackStrong/sprites.atlas"));
		jordanKnockbackStrong = new Animation(1f / 10f, jordanKnockbackStrongAtlas.getRegions());
		jordanKnockbackAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/knockback/sprites.atlas"));
		jordanKnockback = new Animation(1f / 12f, jordanKnockbackAtlas.getRegions());
		jordanLowPunchAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/lowPunch/sprites.atlas"));
		jordanLowPunch = new Animation(1f / 10f, jordanLowPunchAtlas.getRegions());
		jordanJumpStartAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/jump/start/sprites.atlas"));
		jordanJumpStart = new Animation(1f / 10f, jordanJumpStartAtlas.getRegions());
		jordanJumpEndAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/jump/end/sprites.atlas"));
		jordanJumpEnd = new Animation(1f / 10f, jordanJumpEndAtlas.getRegions());
		jordanWalkBackwardsAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/walkBackwards/sprites.atlas"));
		jordanWalkBackwards = new Animation(1f / 10f, jordanWalkBackwardsAtlas.getRegions());
		jordanWalkForwardAtlas = new TextureAtlas(Gdx.files.internal("sprites/jordan/walkForward/sprites.atlas"));
		jordanWalkForward = new Animation(1f / 10f, jordanWalkForwardAtlas.getRegions());


		//HOSHI SPRITES
        hoshiIdleAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/idle/sprites.atlas"));
        hoshiIdle = new Animation(1f / 8f, hoshiIdleAtlas.getRegions());
        hoshiWalkFAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/walkForward/sprites.atlas"));
        hoshiWalkF = new Animation(1f / 8f, hoshiWalkFAtlas.getRegions());
        hoshiWalkBAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/walkBackwards/sprites.atlas"));
        hoshiWalkB = new Animation(1f / 8f, hoshiWalkBAtlas.getRegions());
        hoshiKnockbackAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/knockback/sprites.atlas"));
        hoshiKnocback = new Animation(1f/8f, hoshiKnockbackAtlas.getRegions());
		//rise graphics
		hoshilowPunchAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/rise/lowPunch/sprites.atlas"));
		hoshilowPunch = new Animation(1f / 12f, hoshilowPunchAtlas.getRegions());
		hoshimediumPunchAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/rise/mediumPunch/sprites.atlas"));
		hoshimediumPunch = new Animation(1f / 12f, hoshimediumPunchAtlas.getRegions());
		hoshihighPunchAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/rise/highPunch/sprites.atlas"));
		hoshihighPunch = new Animation(1f / 12f, hoshihighPunchAtlas.getRegions());
		//chie
		hoshilowKickAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/chie/lowKick/sprites.atlas"));
		hoshilowKick = new Animation(1f / 12f, hoshilowKickAtlas.getRegions());
		hoshimediumKickAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/chie/mediumKick/sprites.atlas"));
		hoshimediumKick = new Animation(1f / 12f, hoshimediumKickAtlas.getRegions());
		hoshispecialAtlas = new TextureAtlas(Gdx.files.internal("sprites/hoshi/chie/special/sprites.atlas"));
		hoshispecial = new Animation(1f / 12f, hoshispecialAtlas.getRegions());

		effect = Gdx.audio.newSound(Gdx.files.internal("P4 Select.wav"));

		jordanLowPunchSound = Gdx.audio.newSound(Gdx.files.internal("sounds/jordan/lowPunch.wav"));
		punch = Gdx.audio.newSound(Gdx.files.internal("sounds/punch.wav"));
		swing = Gdx.audio.newSound(Gdx.files.internal("sounds/swing.wav"));
		FIGHT = Gdx.audio.newSound(Gdx.files.internal("FIGHT.wav"));
	}

	public void dispose() {
		batch.dispose();
		reachOut.dispose();
	}

	public void render() {
		batch.begin();


        time = millis();

		chie.setVolume(0.75f);
		reachOut.setVolume(0.75f);
		gods.setVolume(0.75f);
		last.setVolume(0.75f);

		if(fighto) { FIGHT.play(); fighto = false; }

		if (Gdx.input.isKeyJustPressed(NUM_1)) {
			effect.play();
			music1 = true;
			music2 = false;
			music3 = false;
			music4 = false;
		}
		if (Gdx.input.isKeyJustPressed(NUM_2)) {
			effect.play();
			music2 = true;
			music1 = false;
			music3 = false;
			music4 = false;
		}
		if (Gdx.input.isKeyJustPressed(NUM_3)) {
			effect.play();
			music3 = true;
			music1 = false;
			music2 = false;
			music4 = false;
		}
		if (Gdx.input.isKeyJustPressed(NUM_4)) {
			effect.play();
			music4 = true;
			music1 = false;
			music2 = false;
			music3 = false;
		}
		if (music1) {
			chie.play();
			chie.setLooping(true);
			music2 = false;
			music3 = false;
			music4 = false;
			reachOut.dispose();
			gods.dispose();
			last.dispose();
		}
		if (music2) {
			reachOut.play();
			reachOut.setLooping(true);
			music1 = false;
			music3 = false;
			music4 = false;
			chie.dispose();
			gods.dispose();
			last.dispose();
		}
		if (music3) {
			gods.play();
			gods.setLooping(true);
			music1 = false;
			music2 = false;
			music4 = false;
			reachOut.dispose();
			chie.dispose();
			last.dispose();
		}
		if (music4) {
			last.play();
			last.setLooping(true);
			music1 = false;
			music2 = false;
			music3 = false;
			reachOut.dispose();
			chie.dispose();
			gods.dispose();
		}

		elapsedTime += Gdx.graphics.getDeltaTime();
		hoshiTime += Gdx.graphics.getDeltaTime();
		jordanTime += Gdx.graphics.getDeltaTime();
        hoshiAttackTime += Gdx.graphics.getDeltaTime();
        hoshiAttackX = hoshiX - 125;
        hoshiAttackY = hoshiY;
		jordanBounds.setX(jordanX);
		jordanBounds.setY(jordanY);
		hoshiBounds.setX(hoshiX);
		hoshiBounds.setY(hoshiY);
        hoshiAttackBounds.setX(hoshiAttackX);
        hoshiAttackBounds.setY(hoshiY);

		//background
		batch.draw(texture, 0, 0, 1280, 720);
		batch.draw(healthBackground, 0, 0, 1280, 720);
		batch.draw(healthJordan, Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() - 75, 438 * jordanHealth, 38);
		batch.draw(healthHoshi, Gdx.graphics.getWidth() / 10 * 6 - 50, Gdx.graphics.getHeight() - 75, 438 * hoshiHealth, 38);
		batch.draw(jordanFace, Gdx.graphics.getWidth() - 1320, Gdx.graphics.getHeight() - 150, 200, 175);
		batch.draw(hoshiFace, Gdx.graphics.getWidth() - 135, Gdx.graphics.getHeight() - 123, 160, 140);





		//Jordan
		if(!jordanAction && !jordanMovement && !jordanBack) {
            batch.draw(jordanIdle.getKeyFrame(jordanTime, true), (int) jordanX, (int) jordanY);
		}
        if(!Gdx.input.isKeyPressed(NUMPAD_6) && jordanMovement) { jordanMovement = false; }
        if(!Gdx.input.isKeyPressed(NUMPAD_4) && jordanMovement) { jordanMovement = false; }
        if(!Gdx.input.isKeyPressed(NUMPAD_2) && jordanMovement) { jordanMovement = false; }
        if (Gdx.input.isKeyPressed(NUMPAD_6) && !jordanAction && !jordanBack) {
            batch.draw(jordanWalkForward.getKeyFrame(jordanTime, true), (int) jordanX, (int) jordanY);
            jordanX += jordanSpeed * Gdx.graphics.getDeltaTime();
            jordanMovement = true;
        }
        if (Gdx.input.isKeyPressed(NUMPAD_4) && !jordanAction && !jordanBack) {
            batch.draw(jordanWalkBackwards.getKeyFrame(jordanTime, true), (int) jordanX, (int) jordanY);
            jordanX -= jordanSpeed * Gdx.graphics.getDeltaTime();
            jordanMovement = true;
        }
		if(jordanBack) {
            batch.draw(jordanKnockback.getKeyFrame(jordanTime, false), (int) jordanX, (int) jordanY);
            if(jordanKnockback.isAnimationFinished(jordanTime)) { jordanBack = false; }
        }
		if (Gdx.input.isKeyJustPressed(ANY_KEY) && !jordanBack) {
			jordanTime = 0f;
		}
		if (Gdx.input.isKeyJustPressed(NUMPAD_7) && !jordanBack && !jordanAction) {
            if(jordanBounds.overlaps(hoshiBounds)) {
                if(hoshiHealth > 0) { hoshiHealth -= 0.04f; hoshiKnock = true; }
            }
            jordanTime = 0;
			jordan1 = true;
            jordanLowPunchSound.play();
		}
        if(jordan1) {
            jordanAction = true;
            batch.draw(jordanLowPunch.getKeyFrame(jordanTime, false), (int) jordanX, (int) jordanY);
            if(jordanLowPunch.isAnimationFinished(jordanTime)) {
                jordan1 = false;
                jordanAction = false;
            }
        }
		if(Gdx.input.isKeyPressed(NUMPAD_2) && !jordanBack) {
            jordanMovement = true;
			batch.draw(jordanCrouchStart.getKeyFrame(jordanTime, false), (int) jordanX, (int) jordanY);
			if (jordanCrouchStart.isAnimationFinished(jordanTime)) {
				batch.draw(jordanCrouch.getKeyFrame(jordanTime, true), (int) jordanX, (int) jordanY);
				if (Gdx.input.isKeyPressed(A)) {
					batch.draw(jordanCrouchLowPunch.getKeyFrame(jordanTime, false), (int) jordanX, (int) jordanY);
				}
			}
		}
		if (Gdx.input.isKeyPressed(NUMPAD_8) && !jordanBack && !jordanAction) {
			batch.draw(jordanJumpStart.getKeyFrame(jordanTime, false), (int) jordanX, (int) jordanY);
			if (jordanJumpStart.isAnimationFinished(jordanTime)) {
				jordanTime = 0f;
				batch.draw(jordanJump.getKeyFrame(jordanTime, false), (int) jordanX, (int) jordanY);
			}
		}


		//HOSHI
		if (!hoshiMovement  && !hoshiBack && !hoshiKnock) {
			batch.draw(hoshiIdle.getKeyFrame(hoshiTime, true), (int) hoshiX, (int) hoshiY);
		}
		if(hoshiKnock) {
            batch.draw(hoshiKnocback.getKeyFrame(hoshiTime, true), (int) hoshiX, (int) hoshiY);
            if(hoshiKnocback.isAnimationFinished(hoshiTime)) { hoshiKnock = false; }
        }
		if(!Gdx.input.isKeyPressed(DPAD_RIGHT) && hoshiMovement) { hoshiMovement = false; }
        if(!Gdx.input.isKeyPressed(DPAD_LEFT) && hoshiMovement) { hoshiMovement = false; }
		if (Gdx.input.isKeyPressed(DPAD_RIGHT) && !hoshiAction) {
			batch.draw(hoshiWalkB.getKeyFrame(hoshiTime, true), (int) hoshiX, (int) hoshiY);
			hoshiX += Gdx.graphics.getDeltaTime() * hoshiSpeed;
			hoshiMovement = true;
		}
		if (Gdx.input.isKeyPressed(DPAD_LEFT) && !hoshiAction) {
			batch.draw(hoshiWalkF.getKeyFrame(hoshiTime, true), (int) hoshiX, (int) hoshiY);
			hoshiX -= Gdx.graphics.getDeltaTime() * hoshiSpeed;
			hoshiMovement = true;
		}

		if(Gdx.input.isKeyJustPressed(A) && !hoshiAction && !hoshiBack) { hoshi1 = true; hoshiTime = 0f; }
		if(hoshi1) {
            batch.draw(hoshilowPunch.getKeyFrame(hoshiTime, false), (int) hoshiAttackX, (int) hoshiAttackY);
            hoshiAction = true;
            if (hoshilowPunch.isAnimationFinished(hoshiTime)) {
                hoshi1 = false;
                hoshiAction = false;
            }
        }

		if(Gdx.input.isKeyJustPressed(S) && !hoshiAction && !hoshiBack) { hoshi2 = true; hoshiTime = 0f; }
		if(hoshi2) {
            batch.draw(hoshimediumPunch.getKeyFrame(hoshiTime, false), (int) hoshiAttackX, (int) hoshiAttackY);
            hoshiAction = true;
            if(hoshilowPunch.isAnimationFinished(hoshiTime)) {
                hoshi2 = false;
                hoshiAction = false;
            }
        }

		if(Gdx.input.isKeyJustPressed(D) && !hoshiAction && !hoshiBack) { hoshi3 = true; hoshiTime = 0f; }
        if(hoshi3) {
            batch.draw(hoshihighPunch.getKeyFrame(hoshiTime, false), (int) hoshiAttackX, (int) hoshiAttackY);
            hoshiAction = true;
            if(hoshihighPunch.isAnimationFinished(hoshiTime)) {
                hoshi3 = false;
                hoshiAction = false;
            }
        }

		if(Gdx.input.isKeyJustPressed(Z) && !hoshiAction && !hoshiBack) { hoshi4 = true; hoshiTime = 0f; }
        if(hoshi4) {
            batch.draw(hoshilowKick.getKeyFrame(hoshiTime, false), (int) hoshiAttackX, (int) hoshiAttackY);
            hoshiAction = true;
            if(hoshilowKick.isAnimationFinished(hoshiTime)) {
                hoshi4 = false;
                hoshiAction = false;
            }
        }

		if(Gdx.input.isKeyJustPressed(X) && !hoshiAction && !hoshiBack) { hoshi5 = true; hoshiTime = 0f; }
        if(hoshi5) {
            batch.draw(hoshimediumKick.getKeyFrame(hoshiTime, false), (int) hoshiAttackX, (int) hoshiAttackY);
            hoshiAction = true;
            if(hoshimediumKick.isAnimationFinished(hoshiTime)) {
                hoshi5 = false;
                hoshiAction = false;
            }
        }

		if(Gdx.input.isKeyJustPressed(C) && !hoshiAction && !hoshiBack) { hoshi6 = true; hoshiTime = 0f; }
        if(hoshi6) {
            batch.draw(hoshispecial.getKeyFrame(hoshiTime, false), (int) hoshiAttackX, (int) hoshiAttackY);
            hoshiAction = true;
            if(hoshispecial.isAnimationFinished(hoshiTime)) {
                hoshi6 = false;
                hoshiAction = false;
            }
        }


        if ((Gdx.input.isKeyJustPressed(A)) || Gdx.input.isKeyJustPressed(S) || Gdx.input.isKeyJustPressed(D)) {
            swing.play();
            if (jordanBounds.overlaps(hoshiBounds)) {
                if (jordanHealth > 0) {
                    jordanHealth -= 0.04f;
                    jordanBack = true;
                }
            }
        }
        if ((Gdx.input.isKeyJustPressed(Z)) || Gdx.input.isKeyJustPressed(X) || Gdx.input.isKeyJustPressed(C)) {
            punch.play();
            if (jordanBounds.overlaps(hoshiBounds)) {
                if (jordanHealth > 0) {
                    jordanHealth -= 0.04f;
                    jordanBack = true;
                }
            }
        }


        if(time<ttime) {
            batch.draw(round1, 0, 0, 1280, 720);
        }



		if(jordanHealth <= 0) {
			batch.draw(ko, Gdx.graphics.getWidth() / 2 - 225, Gdx.graphics.getHeight() / 2 - 175, 450, 350);
		}

			batch.end();
		}
	}

