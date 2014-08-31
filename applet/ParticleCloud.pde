class ParticleCloud {
  
  Particle[] particles = new Particle[200];
  List<Status> tweets = tc.getTweets();
  List<Status> tweets2 = tc.getTweets2();

  ParticleCloud(Particle[] _particles) {
    particles = _particles;
  }

  ParticleCloud() {
    //particles = new Particle[200];
    for (int i = 0; i < particles.length; i++) {
      particles[i] = new Particle(0,255,0);
    }
  }

  //method that generates "sad" particles into an array
  void makeParticlesSad(){
    for(int i = 0; i < tweets.size(); i++){
      particleArray[i] = new Particle(0,0,255);
    }
  }
  
  //method that generates "happy" particles into an array
  void makeParticlesHappy(){
    for(int i = tweets.size(); i < (tweets.size() + tweets2.size()); i++){
      particleArray[i] = new Particle(0,255,0);
    }
  }

  void display() {
    for (int i = 0; i < particles.length-1; i++) {
      if(particles[i] != null){
          particles[i].display();
      }
      else
        break;
    }
    
  }
}

