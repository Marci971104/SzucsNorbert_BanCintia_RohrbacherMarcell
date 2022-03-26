<!-- @extends("layouts.master")

@section("content")

<div class="row">
    <div class="col-lg-4 offset-lg-4">
        <form class="form-control" action="/store-meal " method="post">
        @csrf      
            <label for="plate">Név</label>
            <input class="form-control" type="text" name="name">

            <label for="calorievalue">Kalória érték</label>
            <input class="form-control" type="text" name="calorievalue">

            <label for="fat">Zsír</label>
            <input class="form-control" type="text" name="fat">

            <label for="protein">Fehérje</label>
            <input class="form-control" type="text" name="protein">
            
            <label for="carbonhydrate">Szénhidrát</label>
            <input class="form-control" type="text" name="carbonhydrate">

            <label for="salt">Só</label>
            <input class="form-control" type="text" name="salt">


            <button class="btn btn-outline-primary" type="submit">Küldés</button>
        </form>
    </div>
</div>

@endsection -->