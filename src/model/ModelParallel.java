package model;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

public class ModelParallel extends Model{

public void step () {
  if (p.size() < 20){
    for (var p : p) {
      p.interact(this);
    }
    for (var p : this.p) {
      p.move();
    }
  } else {
    p.parallelStream().forEach(p -> p.interact(this));
    p.parallelStream().forEach(p -> p.move());
  }
  mergeParticles();
  updateGraphicalRepresentation();
}

  protected void updateGraphicalRepresentation() {
    var d=new ArrayList<DrawableParticle>();
   // p.parallelStream().forEach(p-> d.add(DrawableParticle.of(p)));
    for(var p:this.p){ d.add(DrawableParticle.of(p)); }
    this.pDraw=d;//atomic update
  }










}