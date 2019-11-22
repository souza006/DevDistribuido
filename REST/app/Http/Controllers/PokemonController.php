<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Pokemon;

class PokemonController extends Controller
{
    public function index()
    {
        return Dog::all();
    }
    public function store(Request $request)
    {
        Pokemon::create($request->all());
    }
    public function show($id)
    {
        //
    }
    public function update(Request $request, $id)
    {
        //
    }
    public function destroy($id)
    {
        //
    }
}
