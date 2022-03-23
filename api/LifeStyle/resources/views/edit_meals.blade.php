@extends("layouts.master")

@section("content")

<div class="row">
    <div class="col-lg-4 offset-lg-4">
        <form class="form-control" action="/update-meal" method="post">
        @csrf 
        @method("PUT") 
            <input class="form-control" type="hidden" name="id" value="{{$meal->id}}">
            <label for="name">Név</label>
            <input class="form-control" type="text" name="name" value="{{$meal->name}}">

            <label for="calorievalue">Kalória érték</label>
            <input class="form-control" type="text" name="calorievalue"  value="{{$meal->calorievalue}}">

            <label for="fat">Zsír</label>
            <input class="form-control" type="text" name="fat"  value="{{$meal->fat}}">

            <label for="protein">Fehérje</label>
            <input class="form-control" type="text" name="protein"  value="{{$meal->protein}}">

            <label for="carbonhydrate">Szénhidrát</label>
            <input class="form-control" type="text" name="carbonhydrate"  value="{{$meal->carbonhydrate}}">

            <label for="salt">Só</label>
            <input class="form-control" type="text" name="salt"  value="{{$meal->salt}}">

            <button class="btn btn-outline-primary" type="submit">Küldés</button>
        </form>
    </div>
</div>




@endsection